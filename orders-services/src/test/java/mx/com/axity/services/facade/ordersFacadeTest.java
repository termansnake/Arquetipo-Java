package mx.com.axity.services.facade;

import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class ordersFacadeTest extends BaseTest {

    @Test
    public void ShouldReturnAllUsers() {

        List<OrdersTO> users = this.ordersFacade.getAllUsers();

        Assert.assertEquals(1, users.size());
    }
}