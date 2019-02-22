import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}levelNCategoryManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}levelNCategoryManager/loadLevelNCategory/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateParentCategory = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}levelNCategoryManager/requestCandidateParentCategory/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherParentCategory = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}levelNCategoryManager/transferToAnotherParentCategory/id/anotherParentCategoryId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelNCategoryManager/addProduct/levelNCategoryId/name/brandId/productCoverImage/origin/catalogId/remark/platformId/tokensExpr/`
  const levelNCategoryId = targetObjectId
  const requestParameters = { ...parameters, levelNCategoryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelNCategoryManager/updateProductProperties/levelNCategoryId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const levelNCategoryId = targetObjectId
  const requestParameters = { ...parameters, levelNCategoryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelNCategoryManager/removeProductList/levelNCategoryId/productIds/tokensExpr/`
  const requestParameters = { ...parameters, levelNCategoryId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addNewProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelNCategoryManager/addNewProduct/levelNCategoryId/name/brandId/productCoverImage/origin/catalogId/profileId/remark/platformId/tokensExpr/`
  const levelNCategoryId = targetObjectId
  const requestParameters = { ...parameters, levelNCategoryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateNewProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelNCategoryManager/updateNewProductProperties/levelNCategoryId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const levelNCategoryId = targetObjectId
  const requestParameters = { ...parameters, levelNCategoryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeNewProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelNCategoryManager/removeNewProductList/levelNCategoryId/newProductIds/tokensExpr/`
  const requestParameters = { ...parameters, levelNCategoryId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEditorPickProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelNCategoryManager/addEditorPickProduct/levelNCategoryId/name/brandId/productCoverImage/origin/catalogId/profileId/remark/platformId/tokensExpr/`
  const levelNCategoryId = targetObjectId
  const requestParameters = { ...parameters, levelNCategoryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEditorPickProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelNCategoryManager/updateEditorPickProductProperties/levelNCategoryId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const levelNCategoryId = targetObjectId
  const requestParameters = { ...parameters, levelNCategoryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEditorPickProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelNCategoryManager/removeEditorPickProductList/levelNCategoryId/editorPickProductIds/tokensExpr/`
  const requestParameters = { ...parameters, levelNCategoryId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTopRatedProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelNCategoryManager/addTopRatedProduct/levelNCategoryId/name/brandId/productCoverImage/origin/catalogId/remark/profileId/platformId/tokensExpr/`
  const levelNCategoryId = targetObjectId
  const requestParameters = { ...parameters, levelNCategoryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTopRatedProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelNCategoryManager/updateTopRatedProductProperties/levelNCategoryId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const levelNCategoryId = targetObjectId
  const requestParameters = { ...parameters, levelNCategoryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTopRatedProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelNCategoryManager/removeTopRatedProductList/levelNCategoryId/topRatedProductIds/tokensExpr/`
  const requestParameters = { ...parameters, levelNCategoryId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRecommandProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelNCategoryManager/addRecommandProduct/levelNCategoryId/name/brandId/productCoverImage/origin/catalogId/remark/profileId/platformId/tokensExpr/`
  const levelNCategoryId = targetObjectId
  const requestParameters = { ...parameters, levelNCategoryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRecommandProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelNCategoryManager/updateRecommandProductProperties/levelNCategoryId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const levelNCategoryId = targetObjectId
  const requestParameters = { ...parameters, levelNCategoryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRecommandProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelNCategoryManager/removeRecommandProductList/levelNCategoryId/recommandProductIds/tokensExpr/`
  const requestParameters = { ...parameters, levelNCategoryId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const LevelNCategoryService = { view,
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
  requestCandidateParentCategory,
  transferToAnotherParentCategory }
export default LevelNCategoryService

