package controller;

import java.util.ArrayList;

import javazoom.jl.player.MP3Player;
import model.MusicDAO;
import model.MusicVO;

public class MusicController {
//	노래를 재생/정지 할수있는 객체생성 -> player.jar(MP3Player 객체 활용)
	MP3Player mp3 = new MP3Player();
//	음악 리스트를 담아줄 전역변수
	ArrayList<MusicVO> musicList;
	
	MusicDAO dao = new MusicDAO();
	
//	음악 리스트에 있는 노래 순서를 관리할 수 잇는 전역변수
	int index=0;
	
//	생성자 -> controller객체가 생성되자마자 음악리스트 세팅
	public MusicController() {
		musicList = new MusicDAO().musicList();
	}

//	재생
	public void play() {
		
		 if(mp3.isPlaying()) {
         	mp3.stop();
         }
         mp3.play(musicList.get(index).getPath());
	}
//	정지
	public void stop() {
		if(mp3.isPlaying()) {
         	mp3.stop();
         }
	}
	
//	다음곡
	public void next() {
//		재생중인 음악 멈추기
		if(mp3.isPlaying()) {
         	mp3.stop();
         }
		if(index<musicList.size()-1) {
			index++; //size-1까지 
		} else {
			index=0; //마지막곡에 도달하면 다시 처음으로 돌아가게함
		}
		mp3.play(musicList.get(index).getPath());
	}
	
//	이전곡
	public void back() {
//		재생중인 음악 멈추기
		if(mp3.isPlaying()) {
         	mp3.stop();
         }
		if(index>0) {
			index--;  
		} else {
			index=(musicList.size()-1); //마지막곡에 도달하면 다시 처음으로 돌아가게함
		}
		mp3.play(musicList.get(index).getPath());
	}

//	목록조회
	public ArrayList<MusicVO> musicList(){
		return musicList;
	}
	
	
}
