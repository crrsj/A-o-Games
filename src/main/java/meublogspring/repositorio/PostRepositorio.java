package meublogspring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import meublogspring.modelo.Post;

public interface PostRepositorio extends JpaRepository<Post, Long>{

}
