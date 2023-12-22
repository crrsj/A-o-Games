package meublogspring.Servico;

import java.util.List;

import meublogspring.modelo.Post;

public interface PostServivo {
	List<Post>findAll();
	Post findById(Long id);
	Post save (Post post);
}
