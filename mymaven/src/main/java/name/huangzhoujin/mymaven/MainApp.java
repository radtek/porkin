package name.huangzhoujin.mymaven;

import name.huangzhoujin.mymaven.utils.Constants;
import name.huangzhoujin.mymaven.utils.FileUtil;
import name.huangzhoujin.mymaven.utils.HttpUtil;
import name.huangzhoujin.mymaven.utils.ServiceFacade;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String taskName = null;
		String option1 = null;
		String option2 = null;

		if (args.length == 1) {
			taskName = args[0];
		} else if (args.length == 2) {
			taskName = args[0];
			option1 = args[1];
		} else if (args.length == 3) {
			taskName = args[0];
			option1 = args[1];
			option2 = args[2];
		} else {
			usage();
			return;
		}

		if (taskName.equals(Constants.TASK_RECORD)) {
			if (option1 != null) {
				HttpUtil.exactAll(option1);
			} else {
				HttpUtil.exactAll(ServiceFacade.getPropertiesBean()
						.getRepository());
			}
		} else if (taskName.equals(Constants.TASK_DOWNLOAD)) {
			int count = Integer.parseInt(ServiceFacade.getPropertiesBean()
					.getDownloadCount());
			if (option1 != null) {
				count = Integer.valueOf(option1).intValue();
			}
			HttpUtil.downloadByCount(count);
		} else if (taskName.equals(Constants.TASK_RESET)) {
			if (option1 != null && option2 != null) {
				int from = Integer.parseInt(option1);
				int to = Integer.parseInt(option2);
				ServiceFacade.getRepositoryService().resetRepositoryByRange(
						from, to);
			} else {
				ServiceFacade.getCustomService().resetRepository();
			}

		} else if (taskName.equals(Constants.TASK_EXPORT)) {
			int from = 1;
			int to = Integer.MAX_VALUE - 1;
			if (option1 != null && option2 != null) {
				from = Integer.parseInt(option1);
				to = Integer.parseInt(option2);
			}
			FileUtil.exportByRange(from, to);
		} else if (taskName.equals(Constants.TASK_CLEAR)) {
			ServiceFacade.getRepositoryService().clearRepository();
		} else {
			usage();
		}
		System.out.println(taskName + " is done successfully!");
	}

	private static void usage() {
		System.out.println("MainApp usage:");
		System.out.println("\tjava MainApp task option1 option2");
		System.out.println("\tTasks : record | download | reset | export");
	}

}
