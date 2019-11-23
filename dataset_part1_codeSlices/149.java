Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void onCreate(Bundle savedInstanceState) {
viewPager = (ViewPager) findViewById(R.id.pager);
viewPager.setAdapter(chatViewerAdapter);
viewPager.setOnPageChangeListener(this);
if (SettingsManager.chatsShowBackground()) {
viewPager.setBackgroundDrawable(getResources().getDrawable(R.drawable.chat_background_repeat));//The functional module of image displaying
viewPager.getBackground().setAlpha(30);//buggy code











