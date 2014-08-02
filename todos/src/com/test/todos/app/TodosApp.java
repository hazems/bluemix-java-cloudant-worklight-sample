package com.test.todos.app;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * An "empty" (no methods overriden) implementation of javax.ws.rs.core.Application tells the runtime environment 
 * that the service resources are packaged in the web archive (WAR) and should be scanned for at deployment ...
 */
@ApplicationPath("/*")
public class TodosApp  extends Application {
}
