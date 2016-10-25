package com.schedushare.core.schedule.rest.resource.impl;

import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;
import org.restlet.routing.Router;

import com.google.inject.Guice;
import com.schedushare.common.guice.SchedushareCommonModule;
import com.schedushare.core.guice.SelfInjectingServerResourceModule;
import com.schedushare.core.guice.ServiceModule;
import com.schedushare.core.schedule.rest.resource.ActiveScheduleResource;

public class ActiveScheduleResourceImplTest extends Application {
	@Test 
	public void testReturnsNullWhenNoActiveScheduleFound() {
        ClientResource client = new ClientResource("http://localhost:8118");
        String msg = client.getChild("/schedules/active/1", ActiveScheduleResource.class).getActiveScheduleForUser();
        assertNull(msg);
    }

    /**
	 * Creates the injector.
	 */
	@Before 
	public void createInjector() {
        Guice.createInjector(
            new ServiceModule(),
            new SelfInjectingServerResourceModule(),
            new SchedushareCommonModule()
        );
    }

    /**
	 * Starts internal Rest server.
	 *
	 * @throws Exception the exception
	 */
	@Before 
	public void startComponent() throws Exception {
        component = new Component();
        component.getServers().add(Protocol.HTTP, 8118);
        component.getDefaultHost().attachDefault(this);
        component.start();
    }

    /**
	 * Stops rest server.
	 *
	 * @throws Exception the exception
	 */
	@After public void stopComponent() throws Exception {
        component.stop();
    }

    private volatile Component component;


    @Override public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/activeschedule", ActiveScheduleResourceImpl.class);
        return router;
    }
}
