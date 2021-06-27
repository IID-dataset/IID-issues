Triggering condition: handling a large image
Consequence: abnormal image displaying

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void PopulateSubmissionViewHolder(final SubmissionViewHolder holder, final Submission submission, final Context mContext, boolean fullscreen) {
String url = "";
boolean big = SettingValues.largeThumbnails;
String submissionURL = submission.getUrl();
if (type == ContentType.ImageType.IMAGE) {
} else if (...) {
url = submission.getDataNode().get("preview").get("images").get(0).get("source").get("url").asText();
if ((big || fullscreen) && !blurry) {
} else {
Picasso.with(mContext).load(url).into(holder.thumbImage);//The functional module of image decoding+displaying      buggy code

Error description:line 15, using unsuitable third-party libraries   