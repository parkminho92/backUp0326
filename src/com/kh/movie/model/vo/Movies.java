package com.kh.movie.model.vo;

import java.util.List;


public class Movies {
	private List<Movie> movies;

	public Movies(List<Movie> movies) {
		this.movies = movies;
	}
	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	// 영화 목록에서 영화 제목 찾기
	public String findTitleByNo(Integer movieNo) {
		for(Movie movie: this.movies) {
			if(movie.isEquals(movieNo)) {
				return movie.getTitle();
			}
		}
		return "";
	}
	
}
	