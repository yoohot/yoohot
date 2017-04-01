package test.innerCls.event;

import java.util.ArrayList;
import java.util.List;

public class GreenhouseController extends Controller {

	public class Restart extends Event {

		private List<Event> eventList;

		public Restart(long delayTime, List<Event> eventList) {

			super(delayTime);

			this.eventList = eventList;

			for (Event e : eventList) {
				addEvent(e);
			}

		}

		@Override
		public void action() {

			for (Event e : eventList) {
				e.start();

				addEvent(e);

			}
			start();
			addEvent(this);

		}

	}

	public class TestEvent extends Event {

		public TestEvent(long delayTime) {
			super(delayTime);
		}

		public TestEvent() {
			super(10l);
		}

		@Override
		public void action() {
			System.out.println("hello test");
		}
	}

	public static void main(String[] args) throws Exception {
		GreenhouseController controller = new GreenhouseController();
		List<Event> eventList1 = new ArrayList<Event>();
		eventList1.add(controller.new TestEvent());
		eventList1.add(controller.new TestEvent());

		Restart restart = controller.new Restart(10l, eventList1);

		controller.addEvent(restart);

		while (true) {

			controller.run();

			Thread.sleep(10l);

			if (controller.getEventList().size() == 0)
				return;

		}

	}

}
