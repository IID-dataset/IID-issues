Triggering condition: handling a large image
Consequence: abnormal image displaying

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
TouchImageView image = (TouchImageView) rootView.findViewById(R.id.image);
url = ContentType.getFixedUrl(s.getUrl());
Picasso.with(getActivity()).load(url).into(image);//The functional module of image decoding+displaying      buggy code

Error description:line 9, using unsuitable third-party libraries   