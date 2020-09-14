package kr.or.connect.reservation.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.service.CategoryService;

@RestController
@RequestMapping(path = "/api/categories")
public class CategoryServiceApiController {
	
	@Autowired
	private CategoryService categoryService;
	
    @ApiOperation(value = "덧셈 구하기")
    @ApiResponses({  // Response Message에 대한 Swagger 설명
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Exception")
    })
	@GetMapping("/show")
	public List<Category> show(){
				
		return categoryService.getCategories();
	}
}
