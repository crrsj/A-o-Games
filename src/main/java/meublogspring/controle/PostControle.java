package meublogspring.controle;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import jakarta.validation.Valid;
import meublogspring.Servico.PostServivo;
import meublogspring.modelo.Post;

@Controller
public class PostControle {
   @Autowired
	PostServivo postServico;
   
   @RequestMapping(value = "/posts",method = RequestMethod.GET)
   public ModelAndView getPosts() {
	   ModelAndView mv = new ModelAndView("posts");
	   List<Post> posts = postServico.findAll();
	   mv.addObject("posts", posts);
	   return mv;
   }
   
   @RequestMapping(value = "/posts/{id}",method = RequestMethod.GET)
   public ModelAndView getPostDetalhes(@PathVariable("id") Long id) {
	   ModelAndView mv = new ModelAndView("postDetalhes");
	   Post post = postServico.findById(id);
	   mv.addObject("post",post);
	   return mv;
   }
   @RequestMapping(value = "/newpost", method = RequestMethod.GET)
   public String getPostForm() {
	   return "postForm";
   }
   @RequestMapping(value = "/newpost", method = RequestMethod.POST)   
   public String save(@Valid Post post,BindingResult result,RedirectAttributes attributes) {
	   if(result.hasErrors()) {
		  attributes.addFlashAttribute("mensagem","campos obrigatórios devem ser preenchidos!");
	   return "redirect:/newpost";
	   
	   }
	   post.setData(LocalDate.now());
	   postServico.save(post);
	   return "redirect:/posts";
   }
   
}
