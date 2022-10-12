package com.prueba.carCenter.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prueba.carCenter.dto.MecanicosDto;
import com.prueba.carCenter.entity.Mecanicos;
import com.prueba.carCenter.exception.MecanicoException;
import com.prueba.carCenter.service.MecanicosServiceI;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice.Return;

@Controller
@Slf4j
@RequestMapping("/mecanico")
public class MecanicosController {

	@Autowired
	private MecanicosServiceI mecanicosServiceI;

	private List<MecanicosDto> listarMecanicos;

	@PostConstruct
	public void init() {
//		listarMecanicos = mecanicosServiceI.consultarMecanicosAll().stream().map(Mecanicos::toDto)
//				.collect(Collectors.toList());
		listarMecanicos = mecanicosServiceI.mecanicosEstado("ACTIVO");
	}

	/**
	 * @author RUBEN DARIO PEREZ CORREDOR
	 * @since 09/10/2022
	 * @param model
	 * @return Vista donde se lista en una tabla los mecanicos que se encuentran con
	 *         estado ACTIVO.
	 */
	@GetMapping("/lista")
	public String listarMecanicos(Model model) {
		log.info("Ejecutando Controlador Mecanicos");
		init();
		model.addAttribute("titulo", "Lista de Mecanicos");
		model.addAttribute("mecanico", listarMecanicos);
		log.debug("Se listan los mecanicos que se encuentran disponibles para asignar");
		return "/mecanico/lista";
	}

	/**
	 * @author RUBEN DARIO PEREZ CORREDOR
	 * @since 09/10/2022
	 * @param model
	 * @param documentoMecanico
	 * @return Prepara la creacion del nuevo mecanico en la aplicacion.
	 * @throws Exception
	 */
	@GetMapping("/nuevo")
	public String crear(Model model) throws Exception {

		MecanicosDto mecanicosDto = new MecanicosDto();
		model.addAttribute("titulo", "Formulario: Nuevo Mecanico");
		model.addAttribute("mecanico", mecanicosDto);
		return "/mecanico/nuevo";
	}
	
	@GetMapping("/editar/{documento}")
	public String editar(Model model, @PathVariable("documento") Integer documentoMecanico) throws Exception {
		
		MecanicosDto mecanicosDto = null;
		
		if (documentoMecanico != null) {
			mecanicosDto = mecanicosServiceI.consultarMecanicosById(documentoMecanico).toDto();
		}
		
		model.addAttribute("titulo", "Formulario: Editar Mecanico");
		model.addAttribute("mecanico", mecanicosDto);
		return "/mecanico/editar";
	}

	/**
	 * @author RUBEN DARIO PEREZ CORREDOR
	 * @since 09/10/2022
	 * @param mecanicosDto
	 * @param result
	 * @param model
	 * @param attribute
	 * @return Realiza la operacion de guardar un nuevo mecanico dentro de la
	 * aplicacion.
	 */
	@PostMapping("/guardar")
	public String crearMecanico(@Valid @ModelAttribute MecanicosDto mecanicosDto, BindingResult result, Model model,
			RedirectAttributes attribute) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Mecanico");
			model.addAttribute("mecanico", mecanicosDto);
			return "/mecanico/nuevo";
		}

		mecanicosServiceI.crearMecanico(mecanicosDto);
		//mecanicosServiceI.guardarMecanico(mecanicosDto);
		System.out.println("Mecanico Guardado con exito!");
		attribute.addFlashAttribute("success", "Mecanico Guardado con exito!");
		init();
		return "redirect:/mecanico/lista";
	}
	
	@PostMapping("/editar")
	public String editarMecanico(@Valid @ModelAttribute MecanicosDto mecanicosDto, BindingResult result, Model model,
			RedirectAttributes attribute) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Mecanico");
			model.addAttribute("mecanico", mecanicosDto);
			return "/mecanico/nuevo";
		}

		//mecanicosServiceI.crearMecanico(mecanicosDto);
		mecanicosServiceI.guardarMecanico(mecanicosDto);
		System.out.println("Mecanico Guardado con exito!");
		attribute.addFlashAttribute("success", "Mecanico Guardado con exito!");
		init();
		return "redirect:/mecanico/lista";
	}

	/**
	 * @author RUBEN DARIO PEREZ CORREDOR
	 * @since 09/10/2022
	 * @param model
	 * @param documentoMecanico
	 * @return Presenta la informacion registrada del mecanico consultado.
	 * @throws Exception
	 */
	@GetMapping("/detalle/{id}")
	public String detalle(Model model, @PathVariable("id") Integer documentoMecanico) throws Exception {
		MecanicosDto mecanicosDto = null;
		if (documentoMecanico != null) {
			mecanicosDto = mecanicosServiceI.consultarMecanicosById(documentoMecanico).toDto();
			model.addAttribute("titulo", "Formulario: Detalle Mecanico");
		}
		model.addAttribute("mecanico", mecanicosDto);
		return "/mecanico/detalle";
	}

	/**
	 * @author RUBEN DARIO PEREZ CORREDOR
	 * @since 09/10/2022
	 * @param documentoMecanico
	 * @param attribute
	 * @return Realiza la operacion de borrado del mecanico seleccionado.
	 * @throws Exception
	 */
	@GetMapping("/borrar/{id}")
	public String eliminarMecanico(@PathVariable("id") Integer documentoMecanico, RedirectAttributes attribute)
			throws Exception {

		MecanicosDto mecanicosDto = null;
		
		if (documentoMecanico != null) {
			mecanicosDto = mecanicosServiceI.consultarMecanicosById(documentoMecanico).toDto();

			if (mecanicosDto == null) {
				System.out.println("Error: ATENCION: El ID del Mecanico no exixte!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del Mecanico no exixte!");
				return "redirect:/mecanico/lista";
			}
		} else {
			System.out.println("Error: ATENCION: Error con el ID del Employee!");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del Mecanico!");
			return "redirect:/mecanico/lista";
		}
		mecanicosServiceI.eliminarMecanicoById(documentoMecanico);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");
		return "redirect:/mecanico/lista";
	}

}
