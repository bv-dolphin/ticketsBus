package com.osprey.studio.controller.rest;

import com.osprey.studio.controller.rest.common.AbstractBaseRestController;
import com.osprey.studio.domain.Bus;
import com.osprey.studio.service.BusService;
import com.osprey.studio.service.common.BaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.osprey.studio.controller.rest.BusRestController.NAME_RESOURCE;

@RestController
@RequestMapping("/" + BusRestController.ROOT_PATH)
@Api(description = "/" + NAME_RESOURCE)    // показывает свагер название ресурса
public class BusRestController extends AbstractBaseRestController<Bus> {
    private final BusService busService;
    public static final String ROOT_PATH = "bus";
    public static final String NAME_RESOURCE = "name_resurses";


    public BusRestController(BusService busService) {
        this.busService = busService;
    }

    @Override
    protected BaseService<Bus> getService() {
        return busService;
    }

    @ApiOperation(value = "получение из справочников автобусов\"" + NAME_RESOURCE + "\" значение по уникальному ади", notes = "Возвращает значение", response = Bus.class, httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = NAME_RESOURCE + " Данные получены"),
            @ApiResponse(code = 400, message = NAME_RESOURCE + " Неправильные параметры"),
            @ApiResponse(code = 404, message = NAME_RESOURCE + " Not Found")
    })
    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = "application/dolphin.app-v1.0+json")
    @Override
    public ResponseEntity<Bus> getById(Long id) {
        return super.getById(id);
    }


}
