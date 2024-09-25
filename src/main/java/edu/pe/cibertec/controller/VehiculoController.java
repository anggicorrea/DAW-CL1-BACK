package edu.pe.cibertec.controller;

import edu.pe.cibertec.dto.VehiculoRequest;
import edu.pe.cibertec.dto.VehiculoResponse;
import edu.pe.cibertec.service.VehicuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    VehicuService vehicuService;

    @PostMapping
    public VehiculoResponse buscarVehiculo(@RequestBody VehiculoRequest vehiculoRequest) {
        try {
            String[] datosAutos = vehicuService.buscarVehiculo(vehiculoRequest);
            if (datosAutos == null) {
                return new VehiculoResponse("01", "Error: Auto no encontrado", "", "",
                        "", "", "");
            }
            return new VehiculoResponse("00", "", datosAutos[0], datosAutos[1],
                    datosAutos[2], datosAutos[3], datosAutos[4]);
        } catch (Exception e) {
            return new VehiculoResponse("99", "Error: Ocurrió un problema", "",
                    "", "", "", "");
        }
    }

}
