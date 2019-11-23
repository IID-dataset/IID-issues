Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
private ImageLoader imageLoader = ImageLoader.getInstance();
public View getViewFromVideoInfoItem(View convertView, ViewGroup parent, VideoPreviewInfo info, Context context) {
ViewHolder holder;
if(convertView == null) {
convertView = inflater.inflate(R.layout.video_item, parent, false);
holder = new ViewHolder();
 holder.itemThumbnailView = (ImageView) convertView.findViewById(R.id.itemThumbnailView);
imageLoader.displayImage(info.thumbnail_url, holder.itemThumbnailView);//The functional module of image decoding+displaying      buggy code
