import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}catalogManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}catalogManager/loadCatalog/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateSite = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}catalogManager/requestCandidateSite/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherSite = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}catalogManager/transferToAnotherSite/id/anotherSiteId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}catalogManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}catalogManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addLevelOneCategory = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/addLevelOneCategory/catalogId/name/tokensExpr/`
  const catalogId = targetObjectId
  const requestParameters = { ...parameters, catalogId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateLevelOneCategory = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/updateLevelOneCategoryProperties/catalogId/id/name/tokensExpr/`
  const catalogId = targetObjectId
  const requestParameters = { ...parameters, catalogId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeLevelOneCategoryList = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/removeLevelOneCategoryList/catalogId/levelOneCategoryIds/tokensExpr/`
  const requestParameters = { ...parameters, catalogId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/addProduct/catalogId/name/parentCategoryId/brandId/productCoverImage/origin/remark/platformId/tokensExpr/`
  const catalogId = targetObjectId
  const requestParameters = { ...parameters, catalogId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/updateProductProperties/catalogId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const catalogId = targetObjectId
  const requestParameters = { ...parameters, catalogId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/removeProductList/catalogId/productIds/tokensExpr/`
  const requestParameters = { ...parameters, catalogId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addNewProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/addNewProduct/catalogId/name/parentCategoryId/brandId/productCoverImage/origin/profileId/remark/platformId/tokensExpr/`
  const catalogId = targetObjectId
  const requestParameters = { ...parameters, catalogId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateNewProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/updateNewProductProperties/catalogId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const catalogId = targetObjectId
  const requestParameters = { ...parameters, catalogId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeNewProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/removeNewProductList/catalogId/newProductIds/tokensExpr/`
  const requestParameters = { ...parameters, catalogId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEditorPickProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/addEditorPickProduct/catalogId/name/parentCategoryId/brandId/productCoverImage/origin/profileId/remark/platformId/tokensExpr/`
  const catalogId = targetObjectId
  const requestParameters = { ...parameters, catalogId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEditorPickProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/updateEditorPickProductProperties/catalogId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const catalogId = targetObjectId
  const requestParameters = { ...parameters, catalogId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEditorPickProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/removeEditorPickProductList/catalogId/editorPickProductIds/tokensExpr/`
  const requestParameters = { ...parameters, catalogId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTopRatedProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/addTopRatedProduct/catalogId/name/parentCategoryId/brandId/productCoverImage/origin/remark/profileId/platformId/tokensExpr/`
  const catalogId = targetObjectId
  const requestParameters = { ...parameters, catalogId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTopRatedProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/updateTopRatedProductProperties/catalogId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const catalogId = targetObjectId
  const requestParameters = { ...parameters, catalogId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTopRatedProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/removeTopRatedProductList/catalogId/topRatedProductIds/tokensExpr/`
  const requestParameters = { ...parameters, catalogId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRecommandProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/addRecommandProduct/catalogId/name/parentCategoryId/brandId/productCoverImage/origin/remark/profileId/platformId/tokensExpr/`
  const catalogId = targetObjectId
  const requestParameters = { ...parameters, catalogId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRecommandProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/updateRecommandProductProperties/catalogId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const catalogId = targetObjectId
  const requestParameters = { ...parameters, catalogId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRecommandProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/removeRecommandProductList/catalogId/recommandProductIds/tokensExpr/`
  const requestParameters = { ...parameters, catalogId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const CatalogService = { view,
  load,
  addLevelOneCategory,
  addProduct,
  addNewProduct,
  addEditorPickProduct,
  addTopRatedProduct,
  addRecommandProduct,
  updateLevelOneCategory,
  updateProduct,
  updateNewProduct,
  updateEditorPickProduct,
  updateTopRatedProduct,
  updateRecommandProduct,
  removeLevelOneCategoryList,
  removeProductList,
  removeNewProductList,
  removeEditorPickProductList,
  removeTopRatedProductList,
  removeRecommandProductList,
  requestCandidateSite,
  requestCandidatePlatform,
  transferToAnotherSite,
  transferToAnotherPlatform }
export default CatalogService

