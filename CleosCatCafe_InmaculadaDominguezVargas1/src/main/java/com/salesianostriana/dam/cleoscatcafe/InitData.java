package com.salesianostriana.dam.cleoscatcafe;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.cleoscatcafe.modelo.Gato;
import com.salesianostriana.dam.cleoscatcafe.servicios.GatoServicio;
import com.salesianostriana.dam.cleoscatcafe.servicios.ReservaServicio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {
	
	private final GatoServicio gs;
	private final ReservaServicio rs;
	
	
	@PostConstruct
	public void init () {
		
		List <Gato> gatos = List.of(new Gato(10, "sdgbfgn", "xdgbngfn", "hembra", 1, "xdgb fgn", LocalDate.now(), "xdfng fhn"));
		
		gatos.forEach(gs::save);
	}
	

}
