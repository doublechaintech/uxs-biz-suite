import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}productManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}productManager/loadProduct/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateParentCategory = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}productManager/requestCandidateParentCategory/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherParentCategory = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}productManager/transferToAnotherParentCategory/id/anotherParentCategoryId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateBrand = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}productManager/requestCandidateBrand/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBrand = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}productManager/transferToAnotherBrand/id/anotherBrandId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateCatalog = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}productManager/requestCandidateCatalog/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCatalog = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}productManager/transferToAnotherCatalog/id/anotherCatalogId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}productManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}productManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addRating = (targetObjectId, parameters) => {
  const url = `${PREFIX}productManager/addRating/productId/userId/score/tokensExpr/`
  const productId = targetObjectId
  const requestParameters = { ...parameters, productId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRating = (targetObjectId, parameters) => {
  const url = `${PREFIX}productManager/updateRatingProperties/productId/id/score/tokensExpr/`
  const productId = targetObjectId
  const requestParameters = { ...parameters, productId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRatingList = (targetObjectId, parameters) => {
  const url = `${PREFIX}productManager/removeRatingList/productId/ratingIds/tokensExpr/`
  const requestParameters = { ...parameters, productId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addReview = (targetObjectId, parameters) => {
  const url = `${PREFIX}productManager/addReview/productId/title/content/userId/tokensExpr/`
  const productId = targetObjectId
  const requestParameters = { ...parameters, productId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateReview = (targetObjectId, parameters) => {
  const url = `${PREFIX}productManager/updateReviewProperties/productId/id/title/content/tokensExpr/`
  const productId = targetObjectId
  const requestParameters = { ...parameters, productId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeReviewList = (targetObjectId, parameters) => {
  const url = `${PREFIX}productManager/removeReviewList/productId/reviewIds/tokensExpr/`
  const requestParameters = { ...parameters, productId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addBlog = (targetObjectId, parameters) => {
  const url = `${PREFIX}productManager/addBlog/productId/title/content/userId/tokensExpr/`
  const productId = targetObjectId
  const requestParameters = { ...parameters, productId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateBlog = (targetObjectId, parameters) => {
  const url = `${PREFIX}productManager/updateBlogProperties/productId/id/title/content/tokensExpr/`
  const productId = targetObjectId
  const requestParameters = { ...parameters, productId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeBlogList = (targetObjectId, parameters) => {
  const url = `${PREFIX}productManager/removeBlogList/productId/blogIds/tokensExpr/`
  const requestParameters = { ...parameters, productId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const ProductService = { view,
  load,
  addRating,
  addReview,
  addBlog,
  updateRating,
  updateReview,
  updateBlog,
  removeRatingList,
  removeReviewList,
  removeBlogList,
  requestCandidateParentCategory,
  requestCandidateBrand,
  requestCandidateCatalog,
  requestCandidatePlatform,
  transferToAnotherParentCategory,
  transferToAnotherBrand,
  transferToAnotherCatalog,
  transferToAnotherPlatform }
export default ProductService

