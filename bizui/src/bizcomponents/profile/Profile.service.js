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


const ProfileService = { view,
  load,
  addTarget,
  addRating,
  addReview,
  addBlog,
  updateTarget,
  updateRating,
  updateReview,
  updateBlog,
  removeTargetList,
  removeRatingList,
  removeReviewList,
  removeBlogList,
  requestCandidatePlatform,
  transferToAnotherPlatform }
export default ProfileService

