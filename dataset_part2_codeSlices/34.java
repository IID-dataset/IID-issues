Triggering condition: display large images
Consequence: crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------


public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
super.onViewCreated(view, savedInstanceState);
Bundle args = getArguments();
String source;
String uri = args.getString(IMAGE_URL);
final String path = args.getString(IMAGE_PATH);
if (path != null) source = path;
final String attachmentId = args.getString(ATTACHMENT_ID);
ivPhoto = view.findViewById(R.id.ivPhoto);
progressBar = view.findViewById(R.id.progressBar);
progressBar.setVisibility(View.VISIBLE);
/**
The begin of a functional module: image decoding+displaying
**/
Glide.with(getActivity()).load(source).listener(new RequestListener<Drawable>()).into(ivPhoto);//buggy code 
/**
The end of the functional module: image decoding+displaying
**/

Error description:line 22, Misconfiguration of third-party libraries.







