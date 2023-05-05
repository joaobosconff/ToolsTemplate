package jb.estudo.ferramentas.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class Controller {
	
	private Boolean cacheEnabled = Boolean.TRUE;
	
	@GetMapping("test")
	@Cacheable("test1")
	public String chamadaCache() {
		cacheEnabled = Boolean.TRUE;
		System.out.println("chamada feita, cache habilitado? " + cacheEnabled);
		return "chamada feita, cache habilitado? " + cacheEnabled;
	}
	
	
	@GetMapping("test/clear")
	@CacheEvict("test1")
	public String limparCache() {
		System.out.println("Status Cache test1 : " + cacheEnabled);
		System.out.println("Chamada feita para limpar");
		cacheEnabled = Boolean.FALSE;
		System.out.println("Status Cache test1 : " + cacheEnabled);
		return "Foi limpo";
	}

}
