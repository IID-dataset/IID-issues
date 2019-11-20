Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
rootView = inflater.inflate(R.layout.fragment_view_media, container, false);
photoView = rootView.findViewById(R.id.view_media_image);
final Bundle arguments = Objects.requireNonNull(getArguments(), "Empty arguments");
final Attachment attachment = arguments.getParcelable(ATTACH_ARG);
final String url = attachment.getUrl();
if (arguments.getBoolean(ARG_START_POSTPONED_TRANSITION)) {
} else {
loadImageFromNetwork(url, photoView);
private void loadImageFromNetwork(String url, ImageView photoView) {
/**
The begin of a functional module: image resizing+displaying
**/
Picasso.with(getContext()).load(url).noPlaceholder().into(photoView, new Callback() {});//buggy code
/**
The end of the functional module: image resizing+displaying
**/










