Triggering condition: handling a large image
Consequence: abnormal image displaying

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void PopulateSubmissionViewHolder(final SubmissionViewHolder holder, final Submission submission, final Context mContext, boolean fullscreen) {
String url = "";
boolean big = SettingValues.largeThumbnails;
if (type == ContentType.ImageType.IMAGE) {
} else if (...) {
url = submission.getDataNode().get("preview").get("images").get(0).get("source").get("url").asText();
if ((big || fullscreen) && !blurry) {
Picasso.with(mContext).load(url).into(holder.leadImage);//The functional module of image decoding+displaying      buggy code
