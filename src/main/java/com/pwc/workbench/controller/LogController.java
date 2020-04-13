package com.pwc.workbench.controller;

import com.pwc.workbench.model.LogModel;
import com.pwc.workbench.service.LogService;
import com.pwc.workbench.util.CommonUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

@Api(value = "Log查看")
@RestController
@RequestMapping(value="/api")
public class LogController {

	@Resource
    private LogService logService;

    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @RequestMapping(value = "/getUploadExtLogs", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getUploadExtLogs(@ApiParam(value = "年月", required = true) 
    @RequestParam(value = "actualDate", required = true) String actualDate) {
        Map <String,Object> map=new HashMap<>();
        try {
        	List<LogModel> logs=logService.getLogByAction(CommonUtils.ACTION_UPLOAD_EXT, actualDate);
        	return new ResponseEntity<>(logs, HttpStatus.OK);
        }catch (Exception e){
        	e.printStackTrace();
            map.put("ErrorMessage","System Error");
            logger.error("System Error"+e.getMessage());
        }
        return new ResponseEntity<>(map, HttpStatus.OK);

    }
}

