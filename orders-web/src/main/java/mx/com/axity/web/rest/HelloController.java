package mx.com.axity.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.services.facade.IordersFacade;
import mx.com.axity.services.facade.IserviceorderFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("serviceorders/v1")
@Api(value="orders")
public class HelloController {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    IordersFacade IordersFacade;

    @Autowired
    IserviceorderFacade IserviceorderFacade;

    @GetMapping(value = "/orders", produces = "application/json")
    @ApiOperation(value = "Buscar Ordenes",
            notes = "Retorna todas las ordenes",
            response = OrdersTO.class,
            produces = "application/json")
    public ResponseEntity<List<OrdersTO>> getAllOrders() {
        List<OrdersTO> orders = this.IordersFacade.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/orders/{id}", produces = "application/json")
    @ApiOperation(value = "Buscar Orden por id",
            notes = "Regresa la orden por id",
            response = OrdersTO.class,
            produces = "application/json")
    public ResponseEntity<OrdersTO> getOrderById(@PathVariable("id") int id) {
        OrdersTO orders = this.IordersFacade.getOrdersById(id);
        if (orders != null){
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(orders, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/ping", produces = "application/json")
    @ApiOperation(value = "Ping",
            notes = "Pong",
            produces = "application/json")
    public ResponseEntity test() {
        return new ResponseEntity<>("{pong}", HttpStatus.OK);
    }
}
