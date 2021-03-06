package com.bighit.on.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.bighit.on.email.EmailVO;
import com.bighit.on.user.dao.UsersVO;
import com.bighit.on.workspace.WorkSpaceDaoImpl;
import com.bighit.on.workspace.WorkSpaceService;
import com.bighit.on.workspace.WorkSpaceServiceImpl;
import com.bighit.on.workspace.WorkSpaceVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)//스프랭 테스트 컨텍스트 프레임워크의 JUnit기능 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                                   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"		
})
public class TestWorkSpace {
	Logger  LOG = LoggerFactory.getLogger(TestWorkSpace.class);
	
	@Autowired // 테스트 컨텍스트 프레임워크는 일치하는 컨텍스트를 찾아 DI해 준다.
	WebApplicationContext context;
	
	@Autowired
	WorkSpaceDaoImpl workSpaceDao;
	
	@Autowired
	WorkSpaceServiceImpl workSpaceServiceImpl; 
	
	@Autowired
	WorkSpaceService workSpaceService;
	
	WorkSpaceVO workSpace01;
	WorkSpaceVO workSpace02;
	
	EmailVO email01;
	
	@Before
	public void setUp() throws Exception {
		workSpace01 = new WorkSpaceVO("2","정현수","정현수","jhs","");
		workSpace02 = new WorkSpaceVO("3","jhs_ws","bighit","jhs","");
		
		email01 = new EmailVO("isc8481@hanmail.net", workSpace01.getWsLink(), workSpace01.getWsName(), "slack");
		LOG.debug("** setup() **");
		LOG.debug("** workSpace01 param **:"+workSpace01);
	}

	@After
	public void tearDown() throws Exception {
		LOG.debug("** tearDown() **");
	}

	@Test
	@Ignore
	public void all() {
		LOG.debug("** test **");
		//워크스페이스삭제T
		workSpaceDao.doDelete(workSpace01);
		workSpaceDao.doDelete(workSpace02);
		
		//워크스페이스 생성T
		workSpaceDao.doInsert(workSpace01);
		workSpaceDao.doInsert(workSpace02);
		
		//워크스페이스 단건조회
		workSpaceDao.doSelectOne(workSpace01);
		workSpaceDao.doSelectOne(workSpace02);
	}
	
	//성공
	@Test
	public void doInsert() {
		int flag = workSpaceDao.doInsert(workSpace01);
		assertThat(flag, is(1));
		flag = workSpaceDao.doInsert(workSpace02);
		assertThat(flag, is(1));
	}
	
	//성공
	@Test
	@Ignore
	public void doDelete() {
		int flag = workSpaceDao.doDelete(workSpace01);
		assertThat(flag, is(1));
		flag = workSpaceDao.doDelete(workSpace02);
		assertThat(flag, is(1));
	}
	
	//성공
	@Test
	@Ignore
	public void doSelectOne() {
		workSpaceDao.doSelectOne(workSpace01);
		
	}
	
	@Test
	@Ignore
	//성공
	public void doworkCkService() {
		workSpaceServiceImpl.workSpaceNameCK(workSpace01);
	}
	
	//성공
	@Test
	public void doInserta() {
		workSpaceServiceImpl.doInsert(workSpace01);
		
	}
	
	@Test
	@Ignore
	public void workSpacePCK() {
		workSpaceServiceImpl.workSpacePCK(workSpace01);
	}
	
	@Test
	@Ignore
	public void workSpaceLinkCK() {
		workSpaceServiceImpl.workSpaceLinkCK(workSpace01);
	}
	
	//성공
	@Test
	@Ignore
	public void sendEmail() {
		
		workSpaceService.sendEmail(email01);
	}
	
	//성공
	@Test
	@Ignore
	public void doSelectList() {
		UsersVO userVO = new UsersVO();
		userVO.setEmail("gustn4880@naver.com");
		
		workSpaceDao.doSelectList(userVO);
			
	}
}
