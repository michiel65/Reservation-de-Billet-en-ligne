package reservationBillet.creation;

import java.util.ArrayList;
import java.util.Hashtable;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;


public class ReservationBillet {
	public ArrayList lc;
	public ArrayList lv;
	public ArrayList la;
	private Hashtable catalogue;
	    public Hashtable getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(Hashtable catalogue) {
		this.catalogue = catalogue;
	}
		    public static void main(String[] args) {
		      
		        try {
		           
		            jade.core.Runtime rt = jade.core.Runtime.instance();
		            Properties p = new ExtendedProperties();
		            p.setProperty(Profile.GUI, "true");
		            ProfileImpl proImpl = new ProfileImpl(p);
		            AgentContainer agentContainer = rt.createMainContainer(proImpl);
		            AgentController agentController = agentContainer.createNewAgent("CLIENT", reservationBillet.agent.AgentClient.class.getName(), new Object[]{});
		            agentController.start();
		            agentController = agentContainer.createNewAgent("CHERCHEUR", reservationBillet.agent.AgentChercheur.class.getName(), new Object[]{});
		            agentController.start();
		            agentController = agentContainer.createNewAgent("BASEDEDONNE", reservationBillet.agent.BaseDeDonneeAgent.class.getName(), new Object[]{});
		            agentController.start();
		            agentController = agentContainer.createNewAgent("RESERVATION", reservationBillet.agent.AgentReservation.class.getName(), new Object[]{});
		            agentController.start();
		            agentController = agentContainer.createNewAgent("FACILITATEUR", reservationBillet.agent.AgentFacilitateur.class.getName(), new Object[]{});
		            agentController.start();
		            agentController = agentContainer.createNewAgent("COMPAGNIE", reservationBillet.agent.AgentCompagnie.class.getName(), new Object[]{});
		            agentController.start();
		        } catch (ControllerException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		    }

		}

	
