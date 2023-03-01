package com.diatoz.visitor.management;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import com.diatoz.visitor.management.entity.User;
import com.diatoz.visitor.management.repository.UserDataRepository;
import com.diatoz.visitor.management.service.UserDataService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
class VisitorManagementApplicationTests {


	@Autowired
	private UserDataService userService;


	@MockBean
	private UserDataRepository userDataRepository;



	@Test
	public void getUsersTest(){
		when(userDataRepository.findAll()).thenReturn(Stream.of(new User(1211L,"java",
				"mala","pass"),new User(1122L,"cs",
				"shree","pass")).collect(Collectors.toList()));
		assertEquals(2 , userService.getAll().size());
	}

	@Test
	public void saveUserTest(){
		User user=new User(1123L,"Web","kiran","123");
		when(userDataRepository.save(user)).thenReturn(user);
		assertEquals(user, userDataRepository.save(user));

	}
	@Test
	public void givenEmployeeId_whenDeleteEmployee_thenNothing(){
		long userId = 1123L;

		willDoNothing().given(userDataRepository).deleteById(userId);
		userDataRepository.deleteById(userId);

		verify(userDataRepository, times(1)).deleteById(userId);
	}


}
