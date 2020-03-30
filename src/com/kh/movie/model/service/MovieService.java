package com.kh.movie.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.kh.menubar.controller.NewMoviesDto;
import com.kh.menubar.controller.TopMovieDto;
import com.kh.movie.model.dao.MovieDao;
import com.kh.movie.model.vo.Movie;
import com.kh.movie.model.vo.MovieCBS;
import com.kh.movie.model.vo.PageInfo;
import com.kh.still_image.model.vo.StillImageCBS;

public class MovieService {

  
	/* HAJIN */
	public Movie selectList(int movieNo){
			Connection conn = getConnection();
		Movie m = new MovieDao().selectList(conn, movieNo);
  
  	close(conn);
		return m;
  
  }
  
	public List<Movie> selectScreen(String theaterNo, String screenDate) {
		Connection conn = getConnection();
		
		List<Movie> list = new MovieDao().selectScreen(conn, theaterNo, screenDate);
	
		close(conn);
		return list;
	}


	/** 2. 메인화면에서 보여줄 예매율 상위5위 (SUJIN)
	 * @param num 포스터 Level
	 * @return
	 */
	public List<TopMovieDto> topFiveMovies(int num){
		Connection conn = getConnection();
		
		List<TopMovieDto> tmd = new MovieDao().topFiveMovies(conn, num);
		
		close(conn);
		return tmd;
	}
	
	/** 3. 메인화면에서 보여줄 상영예정작 (SUJIN)
	 * @return
	 */
	public List<NewMoviesDto> newMovies(){
		Connection conn = getConnection();
		
		List<NewMoviesDto> nm = new MovieDao().newMovies(conn);
		
		close(conn);
		
		return nm;
	}
	
	
  /* CBS */
	public int insertMovie(MovieCBS mv, String[] genres, ArrayList<StillImageCBS> list) {
		
		Connection conn = getConnection();
		
		int result1 = new MovieDao().insertMovie(conn,mv);
		
		int result2 = new MovieDao().insertMovieGenre(conn,genres);
		
		int result3 = new MovieDao().InsertStillImage(conn,list);
		
		
		if(result1*result2*result3 ==0) {
			commit(conn);
		
		}else {
			
			rollback(conn);
		}
		close(conn);
		return result1*result2*result3;
	}
	
	public int getOnListCount() {
		
		Connection conn = getConnection();

		int listCount = new MovieDao().getOnListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<MovieCBS> selectOnList(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<MovieCBS> list = new MovieDao().selectOnList(conn,pi);
	
		close(conn);
		
		return list;

	}
	
	public ArrayList<MovieCBS> selectComingList(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<MovieCBS> list = new MovieDao().selectComingList(conn,pi);
		
		close(conn);
		
		return list;
		
	}
	
	public int getComingListCount() {
		
		Connection conn = getConnection();

		int listCount = new MovieDao().getComingListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public int getOffListCount() {

		Connection conn = getConnection();

		int listCount = new MovieDao().getOffListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<MovieCBS> selectOffList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<MovieCBS> list = new MovieDao().selectOffList(conn,pi);
		
		close(conn);
		
		return list;
	}
	
	public String getGenre(int movieNo) {
		
		Connection conn = getConnection();
		
		String genre = new MovieDao().getGenre(conn, movieNo);
		
		close(conn);
		
		return genre;
	}

	public int updateMovie(MovieCBS m, String [] genre) {
	
		Connection conn = getConnection();
		
		int result1 = new MovieDao().updateMovie(conn,m);
		
		int result2 = 0; 
		int result3 = 0;
				
		if(genre!=null) {
		 result2 = new MovieDao().deleteGenre(conn,m);
		 result3 = new MovieDao().updateGenre(conn,genre,m);
		
		}else {
			result2 = 1;
			result3 = 1;
		}
		
		if(result1*result2*result3 >0) {
			
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		
		return result1*result2*result3;
	}

	public String[] getImages(int movieNo) {
		
		Connection conn = getConnection();
		
		String [] result = new MovieDao().getImages(conn, movieNo);
		
		close(conn);
		
		return result;
		}

	public int deleteMovie(int movieNo) {
		
		Connection conn = getConnection();
		
		int result = new MovieDao().deleteMovie(conn,movieNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		
		return result;
	}

	public int rerunMovie(int movieNo, Date rerunDate) {
		
		Connection conn = getConnection();
		
		int result = new MovieDao().rerunMovie(conn,movieNo,rerunDate);
		
		if(result>0) {
			
			commit(conn);
		}else {
			
			rollback(conn);
		}
		close(conn);
		
		return result;
		
		
		
	}

	public ArrayList<MovieCBS> selectWholeMovie(int theaterNo) {
		
		Connection conn = getConnection();
		
		ArrayList<MovieCBS> list = new MovieDao().selectWholeMovie(conn,theaterNo);
		
		close(conn);
		
		return list;
	}

	
}


	
