import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}profileManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}profileManager/loadProfile/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}profileManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}profileManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addUserAlert = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addUserAlert/profileId/message/location/platformId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateUserAlert = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateUserAlertProperties/profileId/id/message/location/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeUserAlertList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeUserAlertList/profileId/userAlertIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTarget = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addTarget/profileId/name/bannerId/location/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTarget = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateTargetProperties/profileId/id/name/location/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTargetList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeTargetList/profileId/targetIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRating = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addRating/profileId/productId/score/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRating = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateRatingProperties/profileId/id/score/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRatingList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeRatingList/profileId/ratingIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addReview = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addReview/profileId/title/content/productId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateReview = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateReviewProperties/profileId/id/title/content/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeReviewList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeReviewList/profileId/reviewIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addBlog = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addBlog/profileId/title/content/productId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateBlog = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateBlogProperties/profileId/id/title/content/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeBlogList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeBlogList/profileId/blogIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addBrandFilter = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addBrandFilter/profileId/name/internalId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateBrandFilter = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateBrandFilterProperties/profileId/id/name/internalId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeBrandFilterList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeBrandFilterList/profileId/brandFilterIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addPriceFilter = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addPriceFilter/profileId/name/priceStart/priceEnd/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updatePriceFilter = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updatePriceFilterProperties/profileId/id/name/priceStart/priceEnd/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removePriceFilterList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removePriceFilterList/profileId/priceFilterIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addCategoryFilter = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addCategoryFilter/profileId/name/internalId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateCategoryFilter = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateCategoryFilterProperties/profileId/id/name/internalId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeCategoryFilterList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeCategoryFilterList/profileId/categoryFilterIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addNewProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addNewProduct/profileId/name/parentCategoryId/brandId/productCoverImage/origin/catalogId/remark/platformId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateNewProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateNewProductProperties/profileId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeNewProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeNewProductList/profileId/newProductIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEditorPickProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addEditorPickProduct/profileId/name/parentCategoryId/brandId/productCoverImage/origin/catalogId/remark/platformId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEditorPickProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateEditorPickProductProperties/profileId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEditorPickProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeEditorPickProductList/profileId/editorPickProductIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTopRatedProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addTopRatedProduct/profileId/name/parentCategoryId/brandId/productCoverImage/origin/catalogId/remark/platformId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTopRatedProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateTopRatedProductProperties/profileId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTopRatedProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeTopRatedProductList/profileId/topRatedProductIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRecommandProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addRecommandProduct/profileId/name/parentCategoryId/brandId/productCoverImage/origin/catalogId/remark/platformId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRecommandProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateRecommandProductProperties/profileId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRecommandProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeRecommandProductList/profileId/recommandProductIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const ProfileService = { view,
  load,
  addUserAlert,
  addTarget,
  addRating,
  addReview,
  addBlog,
  addBrandFilter,
  addPriceFilter,
  addCategoryFilter,
  addNewProduct,
  addEditorPickProduct,
  addTopRatedProduct,
  addRecommandProduct,
  updateUserAlert,
  updateTarget,
  updateRating,
  updateReview,
  updateBlog,
  updateBrandFilter,
  updatePriceFilter,
  updateCategoryFilter,
  updateNewProduct,
  updateEditorPickProduct,
  updateTopRatedProduct,
  updateRecommandProduct,
  removeUserAlertList,
  removeTargetList,
  removeRatingList,
  removeReviewList,
  removeBlogList,
  removeBrandFilterList,
  removePriceFilterList,
  removeCategoryFilterList,
  removeNewProductList,
  removeEditorPickProductList,
  removeTopRatedProductList,
  removeRecommandProductList,
  requestCandidatePlatform,
  transferToAnotherPlatform }
export default ProfileService

