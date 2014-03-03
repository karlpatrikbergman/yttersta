package se.patrikbergman.yttersta;

import se.patrikbergman.yttersta.ejb.BandServiceBean;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class JaxRsActivator extends Application { }

