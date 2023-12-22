package meublogspring.Servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meublogspring.modelo.Post;
import meublogspring.repositorio.PostRepositorio;

@Service
public class PostServicoImpl implements PostServivo {
	
	@Autowired
	PostRepositorio postRepositorio;

	@Override
	public List<Post> findAll() {
		
		return postRepositorio.findAll() ;
	}

	@Override
	public Post findById(Long id) {
	
		return postRepositorio.findById(id).get() ;
	}

	@Override
	public Post save(Post post) {
	
		return postRepositorio.save(post) ;
	}

}
