/*******************************************************************************
 * Unpublished Work. Copyright 2009-2022 Transverse, LLC. All Rights Reserved.
 * This software contains confidential and trade secret information of:
 * Transverse, LLC.
 * 600 Congress Ave.
 * Suite 2800
 * Austin, TX 78701
 * USA
 * Use, duplication or disclosure of this software is prohibited
 * without prior written permission of Transverse, LLC.
 ******************************************************************************/

package com.saten.spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cloud.localstack.ServiceName;
import cloud.localstack.docker.LocalstackDockerExtension;
import cloud.localstack.docker.annotation.LocalstackDockerProperties;

@ExtendWith(value = { LocalstackDockerExtension.class, SpringExtension.class })
@LocalstackDockerProperties(services = { ServiceName.S3 })
@ContextConfiguration(classes = { S3TestConfiguration.class })
@TestPropertySource(locations = "classpath:application.properties")
public class AWSS3ServiceTest {

	@Test
	public void testCreateFolder() throws Exception {
		
	}

}
