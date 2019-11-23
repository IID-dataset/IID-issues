Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public Notification buildNotification(Context context) {
NotificationCompat.Builder builder = getBaseBuilder(context, instance).setContentTitle(notificationTitle).setContentText(contentText).setLargeIcon(getLargeIconFormattedForPlatform(context, R.drawable.ic_access_time_white_24dp));
public NotificationCompat.Builder getBaseBuilder(Context context, Intent activityIntent) {
NotificationCompat.Builder builder = getBaseBuilder(context);
return builder;	
public NotificationCompat.Builder getBaseBuilder(Context context) {
return new NotificationCompat.Builder(context).setSmallIcon(R.drawable.ic_notification).setGroup(GCMMessageHandler.GROUP_KEY).setColor(context.getResources().getColor(R.color.accent_dark)).setAutoCancel(true).extend(new NotificationCompat.WearableExtender().setBackground(BitmapFactory.decodeResource(context.getResources(), R.drawable.tba_blue_background)));  //The functional module of image decoding+displayingbuggy code
