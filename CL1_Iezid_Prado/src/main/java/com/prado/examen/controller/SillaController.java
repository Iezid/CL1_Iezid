package com.prado.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prado.examen.entity.Marca;
import com.prado.examen.entity.Silla;
import com.prado.examen.services.MarcaServices;
import com.prado.examen.services.SillaServices;

@Controller
@RequestMapping("/silla")
public class SillaController {
	
	@Autowired
	private SillaServices servicioSil;
	
	@Autowired
	private MarcaServices servicioMa;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("silla", servicioSil.listarTodos());
		model.addAttribute("marca",servicioMa.listarTodos());
		return "silla";
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo")Integer cod,
			             @RequestParam("descrip")String des,
			             @RequestParam("precio")double pre,
			             @RequestParam("stock") int stock,
			             @RequestParam("marca") int  codMarca,
			             RedirectAttributes redirect) {
		
		try {
			
			Silla sil=new Silla();
			
			sil.setDescrip(des);
			sil.setPrecio(pre);
			sil.setStock(stock);
			
			Marca ma=new Marca();
			
			ma.setCodigo(codMarca);
			sil.setMarca(ma);
			
			if(cod==0) {
				servicioSil.registrar(sil);
				redirect.addFlashAttribute("MENSAJE","SILLA REGISTRADA");
			}
			else {
			    sil.setCodigo(cod);
			    servicioSil.actualizar(sil);
			    redirect.addFlashAttribute("MENSAJE","MEDICAMENTO ACTUALIZADO");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/silla/lista";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Silla buscar(@RequestParam("codigo") Integer cod) {
		return servicioSil.buscarPorID(cod);
	}

}
