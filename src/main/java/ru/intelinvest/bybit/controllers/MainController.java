package ru.intelinvest.bybit.controllers;

import ru.intelinvest.bybit.models.Credentials;
import ru.intelinvest.bybit.models.DealsImportResult;
import ru.intelinvest.bybit.services.BybitService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
@RestController
@RequestMapping("/input")
public class MainController {

    @Autowired
    private BybitService bybitService;

    @PostMapping("/credentials")
    public ResponseEntity<DealsImportResult> getBybitData(@RequestBody Credentials credentials) throws NoSuchAlgorithmException, InvalidKeyException, JSONException, InterruptedException, IOException {
        String apiKey = credentials.getAccessKey();
        String apiSecret = credentials.getSecretKey();
        String startDate = credentials.getStartDate();
        log.info(String.format("apiKey = %s", apiKey));
        log.info(String.format("apiSecret = %s", apiSecret));
        log.info(String.format("startDate = %s", startDate));
        DealsImportResult response = bybitService.getBybitDealImportResult(apiKey, apiSecret, startDate);
        log.info("Success!");
        return ResponseEntity.ok(response);
    }
}
