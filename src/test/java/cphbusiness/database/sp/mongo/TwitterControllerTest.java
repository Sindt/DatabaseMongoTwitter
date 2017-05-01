package cphbusiness.database.sp.mongo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mongodb.client.MongoCursor;

import cphbusiness.database.sp.mongo.twitter.boundary.TwitterService;
import cphbusiness.database.sp.mongo.twitter.controller.TwitterController;

@RunWith(MockitoJUnitRunner.class)
public class TwitterControllerTest {

	@Mock
	private TwitterService service;

	@InjectMocks
	private TwitterController controller;

	private MongoCursor<String> userlistMock = mock(MongoCursor.class);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCountAllUsers() {
		when(service.getAllUsers()).thenReturn(userlistMock);
		when(userlistMock.hasNext()).thenReturn(true).thenReturn(false);
		when(userlistMock.next()).thenReturn("TestUser");

		Response response = controller.getCountAllUsers().build();
		int result = (int) response.getEntity();

		assertThat(result, is(1));
	}

	@Test
	@Ignore 
	public void testGetUsersWithMostLinks() {
		when(service.getAllUsers()).thenReturn(userlistMock);

		Response response = controller.getUsersWithMostLinks().build();

		List<String> result = (List<String>) response.getEntity();

		assertThat(result.isEmpty(), is(false));

	}

}
