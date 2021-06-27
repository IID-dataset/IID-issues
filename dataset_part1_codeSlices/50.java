Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onCreate(Bundle savedInstanceState) {
public void onClick(View v) {
showPreviousView();
private void showPreviousView() {
FormController formController = Collect.getInstance().getFormController();
if (formController.getEvent() != FormEntryController.EVENT_BEGINNING_OF_FORM) {
int event = formController.stepToPreviousScreenEvent();
if (event == FormEntryController.EVENT_GROUP|| event == FormEntryController.EVENT_QUESTION) {
if ((++viewCount) % SAVEPOINT_INTERVAL == 0) {
View next = createView(event, false);
private View createView(int event, boolean advancingPage) {
ODKView odkv = null;
FormEntryPrompt[] prompts = formController.getQuestionPrompts();
FormEntryCaption[] groups = formController.getGroupsForCurrentIndex();
odkv = new ODKView(this, formController.getQuestionPrompts(),groups, advancingPage);
public ODKView(Context context, final FormEntryPrompt[] questionPrompts,
FormEntryCaption[] groups, boolean advancingPage) {
QuestionWidget qw =WidgetFactory.createWidgetFromPrompt(p, getContext(), readOnlyOverride);
public static QuestionWidget createWidgetFromPrompt(FormEntryPrompt fep, Context context,
questionWidget = new ImageWidget(context, fep, true);
public ImageWidget(Context context, final FormEntryPrompt prompt, final boolean selfie) {
imageView = new ImageView(getContext());
DisplayMetrics metrics = context.getResources().getDisplayMetrics();
int screenWidth = metrics.widthPixels;
int screenHeight = metrics.heightPixels;
File f = new File(instanceFolder + File.separator + binaryName);
if (f.exists()) {
Bitmap bmp = FileUtils.getBitmapScaledToDisplay(f, screenHeight, screenWidth);
/**
The begin of a functional module: image resizing
**/
public static Bitmap getBitmapScaledToDisplay(File f, int screenHeight, int screenWidth) {
BitmapFactory.Options o = new BitmapFactory.Options();
o.inJustDecodeBounds = true;
BitmapFactory.decodeFile(f.getAbsolutePath(), o);
int heightScale = o.outHeight / screenHeight;
int widthScale = o.outWidth / screenWidth;
int scale = Math.max(widthScale, heightScale);
BitmapFactory.Options options = new BitmapFactory.Options();
options.inInputShareable = true;
options.inPurgeable = true;
options.inSampleSize = scale;
/**
The end of the functional module: image resizing
**/
Bitmap b = BitmapFactory.decodeFile(f.getAbsolutePath(), options);   //The functional module of image decoding     buggy code
return b;
imageView.setImageBitmap(bmp);//The functional module of image displaying

Error description:line 51, inappropriate code implementation

