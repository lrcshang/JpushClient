import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

public class Main {
	public static void main(String[] args) {
		push();
	}

	private static void push() {
		String masterSecret = "91702094c9d9ff09d64b76e3";
		String appKey = "62afdeac292264f787bc7b59";
		JPushClient jPushClient = new JPushClient(masterSecret, appKey);
		PushPayload payload = PushPayload.newBuilder()
				.setPlatform(Platform.all())
				.setAudience(Audience.alias("陈天任"))
				.setNotification(Notification.alert("我是服务器"))
				.setMessage(Message.content("耶耶耶")).build();
		try {
			PushResult result = jPushClient.sendPush(payload);
			System.out.println(result);
		} catch (APIConnectionException | APIRequestException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

}
