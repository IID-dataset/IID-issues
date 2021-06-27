Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
VideoInfo videoInfo = VideoInfo.getVideoInfo(streamExtractor, new Downloader());
public void run() {
updateInfo(videoInfo);
private ImageLoader imageLoader = ImageLoader.getInstance();
private void updateInfo(VideoInfo info) {
currentVideoInfo = info;
VideoInfoItemViewCreator videoItemViewCreator =new VideoInfoItemViewCreator(LayoutInflater.from(getActivity()));
switch (info.errorCode) {
case VideoInfo.NO_ERROR: {
View nextVideoView = videoItemViewCreator.getViewFromVideoInfoItem(null, nextVideoFrame, info.nextVideo, getContext());
ImageView rthumb = (ImageView)similarView.findViewById(R.id.itemThumbnailView);
imageLoader.displayImage(item.thumbnail_url, rthumb);//The functional module of image decoding+displaying      buggy code

Error description:line 18, using unsuitable third-party libraries   