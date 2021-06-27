Triggering condition: handling a large image
Consequence: abnormal image displaying

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void PopulateSubmissionViewHolder(final SubmissionViewHolder holder, final Submission submission, final Context mContext, boolean fullscreen) {
public void onClick(View view) {
if ((SettingValues.NSFWPreviews && submission.getThumbnailType() == Submission.ThumbnailType.NSFW) || submission.getThumbnailType() == Submission.ThumbnailType.URL) {
Picasso.with(mContext).load(submission.getThumbnail()).into(holder.thumbImage);//The functional module of image decoding+displaying      buggy code

Error description:line 9, using unsuitable third-party libraries   