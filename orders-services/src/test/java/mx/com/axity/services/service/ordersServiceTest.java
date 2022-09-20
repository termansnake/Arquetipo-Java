package mx.com.axity.services.service;

import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class ordersServiceTest extends BaseTest {

    @Test
    public void exampleTest() {

        List<OrdersTO> users = this.ordersService.getUsers();

        Assert.assertEquals(1, users.size());
    }
}
