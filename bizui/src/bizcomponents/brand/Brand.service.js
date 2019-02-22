import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}brandManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}brandManager/loadBrand/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}brandManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}brandManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/addProduct/brandId/name/parentCategoryId/productCoverImage/origin/catalogId/remark/platformId/tokensExpr/`
  const brandId = targetObjectId
  const requestParameters = { ...parameters, brandId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/updateProductProperties/brandId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const brandId = targetObjectId
  const requestParameters = { ...parameters, brandId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/removeProductList/brandId/productIds/tokensExpr/`
  const requestParameters = { ...parameters, brandId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addNewProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/addNewProduct/brandId/name/parentCategoryId/productCoverImage/origin/catalogId/profileId/remark/platformId/tokensExpr/`
  const brandId = targetObjectId
  const requestParameters = { ...parameters, brandId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateNewProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/updateNewProductProperties/brandId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const brandId = targetObjectId
  const requestParameters = { ...parameters, brandId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeNewProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/removeNewProductList/brandId/newProductIds/tokensExpr/`
  const requestParameters = { ...parameters, brandId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEditorPickProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/addEditorPickProduct/brandId/name/parentCategoryId/productCoverImage/origin/catalogId/profileId/remark/platformId/tokensExpr/`
  const brandId = targetObjectId
  const requestParameters = { ...parameters, brandId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEditorPickProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/updateEditorPickProductProperties/brandId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const brandId = targetObjectId
  const requestParameters = { ...parameters, brandId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEditorPickProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/removeEditorPickProductList/brandId/editorPickProductIds/tokensExpr/`
  const requestParameters = { ...parameters, brandId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTopRatedProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/addTopRatedProduct/brandId/name/parentCategoryId/productCoverImage/origin/catalogId/remark/profileId/platformId/tokensExpr/`
  const brandId = targetObjectId
  const requestParameters = { ...parameters, brandId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTopRatedProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/updateTopRatedProductProperties/brandId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const brandId = targetObjectId
  const requestParameters = { ...parameters, brandId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTopRatedProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/removeTopRatedProductList/brandId/topRatedProductIds/tokensExpr/`
  const requestParameters = { ...parameters, brandId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRecommandProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/addRecommandProduct/brandId/name/parentCategoryId/productCoverImage/origin/catalogId/remark/profileId/platformId/tokensExpr/`
  const brandId = targetObjectId
  const requestParameters = { ...parameters, brandId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRecommandProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/updateRecommandProductProperties/brandId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const brandId = targetObjectId
  const requestParameters = { ...parameters, brandId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRecommandProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}brandManager/removeRecommandProductList/brandId/recommandProductIds/tokensExpr/`
  const requestParameters = { ...parameters, brandId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const BrandService = { view,
  load,
  addProduct,
  addNewProduct,
  addEditorPickProduct,
  addTopRatedProduct,
  addRecommandProduct,
  updateProduct,
  updateNewProduct,
  updateEditorPickProduct,
  updateTopRatedProduct,
  updateRecommandProduct,
  removeProductList,
  removeNewProductList,
  removeEditorPickProductList,
  removeTopRatedProductList,
  removeRecommandProductList,
  requestCandidatePlatform,
  transferToAnotherPlatform }
export default BrandService

