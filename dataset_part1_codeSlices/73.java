Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
protected void showFeedInformation(final Feed feed, final Map<String, String> alternateFeedUrls) {
ImageView cover = (ImageView) header.findViewById(R.id.imgvCover);
if (feed.getImage() != null && StringUtils.isNotBlank(feed.getImage().getDownload_url())) {
Glide.with(this).load(feed.getImage().getDownload_url()).placeholder(R.color.light_gray).diskCacheStrategy(DiskCacheStrategy.SOURCE).fitCenter().dontAnimate().into(cover);//The functional module of image decoding+resizing+disk-caching+displaying     buggy code
