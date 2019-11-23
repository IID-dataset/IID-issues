Triggering condition: handling a large image
Consequence: abnormal image displaying

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void PopulateSubmissionViewHolder(final SubmissionViewHolder holder, final Submission submission, final Context mContext, boolean fullscreen) {
String url = "";
boolean big = SettingValues.largeThumbnails;
String submissionURL = submission.getUrl();
if (type == ContentType.ImageType.IMAGE) {
url = ContentType.getFixedUrl(submission.getUrl());
if (big || fullscreen) {
} else {
Picasso.with(mContext).load(url).into(holder.thumbImage);//The functional module of image decoding+displaying      buggy code
            