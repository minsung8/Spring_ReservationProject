package kr.or.connect.reservation.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.service.CategoryService;
import kr.or.connect.reservation.service.impl.CategoryServiceImpl;

@Controller
public class Api { 
	
    @Autowired
    private CategoryService cs;
 
    @GetMapping(path="/list")
    public String list(ModelMap model) {
    	List<Category> list = cs.getCategories();
    	 
    	
    	model.addAttribute("list", list);
    	return "list";
    }

}
