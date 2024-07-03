package pti.sb_treasurehunter_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pti.sb_treasurehunter_mvc.db.Database;
import pti.sb_treasurehunter_mvc.dto.UserDto;
import pti.sb_treasurehunter_mvc.model.User;

@Service
public class AppService {

	private Database db;
	
	
	@Autowired
	public AppService(Database db) {
		super();
		this.db = db;
	}



	public UserDto doLogin(String userName, String userPassword) {
		
		UserDto userDto = null;
		
		User user = db.getUserByNameAndPassword(userName, userPassword);
		if(user != null) {
			userDto = convertUserToUserDto(user);
		}
		
		return userDto;
	}

	

	private UserDto convertUserToUserDto(User user) {
		
		UserDto userDto = null;
		
		userDto = new UserDto(
					user.getId(),
					user.getName(),
					user.getRecordSteps(),
					null
				);
		
		return userDto;
	}



	public UserDto saveGame(int userId, int win, int steps) {
		
		UserDto userDto = null;
		
		User user = db.getUserById(userId);
		
		if(user != null) {
			
			if((win == 1) && ((user.getRecordSteps() == null) || (steps < user.getRecordSteps()))) {
			
				user.setRecordSteps(steps);
				db.updateUser(user);
			}
			
			userDto = convertUserToUserDto(user);
			
			
			switch(win) {
				case 1:
					userDto.setWin(true);
					break;
				case 2:
					userDto.setWin(false);
					break;
				default:
					userDto.setWin(null);
					break;
			}
		}
		
		
		return userDto;
	}

}













