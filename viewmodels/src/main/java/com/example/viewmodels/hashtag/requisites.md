1 - Screen with a list of hashtags
2 - That screen comes from the home

Core classes
Presentation layer
 - HashtagListViewModel
Domain Layer
 - GetListOfHashTagsUseCase
Data Layer
 - HashtagRepository
 - ApiInterface -> D inversion and Injection
OutermostLayer
 - HashtagApi -> we can mock that       
 - UI + Compose