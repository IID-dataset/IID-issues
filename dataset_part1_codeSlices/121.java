Triggering condition: handling a large image
Consequence: abnormal image displaying

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
TouchImageView image = (TouchImageView) rootView.findViewById(R.id.image);
String url = "";
if (type.toString().toLowerCase().contains("image")) {
} else if (...) {
url = s.getDataNode().get("preview").get("images").get(0).get("source").get("url").asText();
Picasso.with(getActivity()).load(url).into(image);//The functional module of image decoding+displaying      buggy code


