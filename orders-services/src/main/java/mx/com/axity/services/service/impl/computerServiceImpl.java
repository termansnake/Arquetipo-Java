package mx.com.axity.services.service.impl;

import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.model.ComputerDO;
import mx.com.axity.model.OrdersDO;
import mx.com.axity.persistence.ComputerDAO;
import mx.com.axity.services.service.IcomputerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class computerServiceImpl implements IcomputerService {

    static final Logger LOG = LogManager.getLogger(computerServiceImpl.class);

    @Autowired
    ComputerDAO computerDAO;

    @Autowired
    monitorServiceImpl monitor;

    @Autowired
    mouseServiceImpl mouse;

    @Autowired
    keyboardServiceImpl keyboard;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ComputerTO getComputeryId(int idcomputer) {
        LOG.info("Consultando ordenes");
        ComputerDO computerDO = this.computerDAO.findByIdcomputer(idcomputer);
        Type DAOType = new TypeToken<ComputerTO>() {}.getType();
        ComputerTO computerTO = this.modelMapper.map(computerDO, DAOType);
        computerTO.setMonitor(monitor.getMonitorById(computerTO.getIdmonitor()));
        computerTO.setMouse(mouse.getMouseById(computerTO.getIdmouse()));
        computerTO.setKeyboard(keyboard.getKeyBoardById(computerTO.getIdkeyboard()));
        LOG.info("Se retornan {} elementos", computerTO);
        return computerTO;
    }
}
