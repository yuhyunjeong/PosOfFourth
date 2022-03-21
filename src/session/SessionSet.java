package session;

import java.util.HashSet;
import java.util.Set;

public class SessionSet {//싱글톤

	private static SessionSet ss = new SessionSet();
	private Set<Session> set;

	private SessionSet() {
		set = new HashSet<>(); //key는 중복 불가능, value는 중복 허용
	}

	public static SessionSet getInstance() {
		return ss;
	}

	/**
	 * 사용자 찾기
	 * */
	public Session get(String sessionId) {
		for(Session session : set) {
			if(session.getSessionId().equals(sessionId)) {
				return session;
			}
		}
		return null;
	}

	//세션 객체들 반환
	public Set<Session> getSet(){
		return set;
	}


	/**
	 * 로그인 된 사용자 추가
	 * */
	public void add(Session session) {
		set.add(session);
	}

	/**
	 * 사용자 제거 - 로그아웃
	 * */
	public void remove(Session session) {
		set.remove(session);
	}
}

